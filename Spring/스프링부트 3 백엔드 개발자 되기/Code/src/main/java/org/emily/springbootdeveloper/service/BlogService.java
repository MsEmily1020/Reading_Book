package org.emily.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import org.emily.springbootdeveloper.domain.Article;
import org.emily.springbootdeveloper.dto.AddArticleRequest;
import org.emily.springbootdeveloper.repository.BlogRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BlogService {
    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }
}
