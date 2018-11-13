package service;

import java.util.List;
import java.util.Map;

import entity.User;

public interface QueryUserAll {

	

	public Map<String, Object> queryUserAll(int page, int num);
}
