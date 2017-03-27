package com.thr.dao;

import java.util.List;

import com.thr.po.Student;

public interface IStudentDao {

	/**
	 * ��ѯ���е�ѧ��
	 * @return
	 */
	List<Student> sellectAll();
	
	/**
	 * ����id��ѯ����ѧ��
	 * @param id
	 * @return
	 */
	Student getStudent(int id);
	
	/**
	 * ���ѧ��
	 * @param student
	 */
	void addStudent(Student student);
	
	/**
	 * �޸�ѧ��
	 * @param student
	 */
	void updateStudent(Student student);
	
	/**
	 * ɾ��ѧ��
	 * @param id
	 */
	void deleteStudent(int id);
	
	/**
	 * ����ѧ��id��ѯ�䰮��
	 * @param id
	 */
	List<String> selectHabits(int id);
}
