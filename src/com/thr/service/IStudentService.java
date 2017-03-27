package com.thr.service;

import java.util.List;

import com.thr.po.Student;

public interface IStudentService {

	/**
	 * 查询所有的学生
	 * @return
	 */
	List<Student> sellectAll();
	
	/**
	 * 根据id查询单个学生
	 * @param id
	 * @return
	 */
	Student getStudent(int id);
	
	/**
	 * 添加学生
	 * @param student
	 */
	void addStudent(Student student);
	
	/**
	 * 修改学生
	 * @param student
	 */
	void updateStudent(Student student);
	
	/**
	 * 删除学生
	 * @param id
	 */
	void deleteStudent(int id);
	
	/**
	 * 根据学生id查询其爱好
	 * @param id
	 */
	List<String> selectHabits(int id);
}
