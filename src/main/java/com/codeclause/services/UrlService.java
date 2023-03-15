package com.codeclause.services;

import com.codeclause.repository.UrlRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Date;

@Service
public class UrlService {
    private final UrlRepository urlRepository;
    private final UrlBaseHandler handler;

    public UrlService(UrlRepository urlRepository, UrlBaseHandler handler) {
        this.urlRepository = urlRepository;
        this.handler = handler;
    }
    
    public String getOriginalUrl(String shortUrl) {
        var id = handler.decode(shortUrl);
        var entity = urlRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("There is no entity with " + shortUrl));

        if (entity.getExpiresDate() != null && entity.getExpiresDate().before(new Date())){
            urlRepository.delete(entity);
            throw new EntityNotFoundException("Link expired!");
        }

        return entity.getLongUrl();
    }
}
