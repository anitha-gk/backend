package com.whatyourdoing.whatyourdoing.data;

import com.whatyourdoing.whatyourdoing.models.UserInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends CrudRepository<UserInfo,Integer> {
}
