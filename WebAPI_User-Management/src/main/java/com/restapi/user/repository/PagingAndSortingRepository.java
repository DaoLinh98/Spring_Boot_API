//package com.restapi.user.repository;
//
//import com.restapi.user.entity.User;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.repository.CrudRepository;
//
//import java.util.List;
//
//public interface PagingAndSortingRepository<T, ID> extends CrudRepository<T, ID> {
//    Iterable<T> findAll(Sort sort);
//    List<User> findByTitleContaining(String title, Sort sort);
//
//    /**
//     * Returns a {@link Page} of entities meeting the paging restriction provided in the {@code Pageable} object.
//     *
//     * @param pageable
//     * @return a page of entities
//     */
//    Page < T > findAll(Pageable pageable);
//}
