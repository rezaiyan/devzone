package com.sivalabs.devzone.posts.adapter.repositories;

import com.sivalabs.devzone.posts.adapter.mappers.CategoryMapper;
import com.sivalabs.devzone.posts.domain.models.Category;
import com.sivalabs.devzone.posts.gateways.data.repository.CategoryRepository;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
class CategoryRepositoryImpl implements CategoryRepository {
    private final JpaCategoryRepository jpaCategoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryRepositoryImpl(
            JpaCategoryRepository jpaCategoryRepository, CategoryMapper categoryMapper) {
        this.jpaCategoryRepository = jpaCategoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public List<Category> findAll() {
        Sort sort = Sort.by("name");
        return jpaCategoryRepository.findAllCategories(sort);
    }

    @Override
    public void upsert(Category category) {
        var entity = categoryMapper.toEntity(category);
        jpaCategoryRepository.upsert(entity);
    }
}
