package com.thr.service.impl;

import java.util.List;

import com.thr.dao.IStudentDao;
import com.thr.dao.impl.StudentDaoImpl;
import com.thr.po.Student;
import com.thr.service.IStudentService;

public class StudentServiceImpl implements IStudentService {

	private IStudentDao studentDao = null;
	public StudentServiceImpl() {
		studentDao = new StudentDaoImpl();
	}
	
	@Override
	public List<Student> sellectAll() {
		return studentDao.sellectAll();
	}

	@Override
	public Student getStudent(int id) {
		System.out.println("进入通过id获得学生service，id:" + id);
		Student student = studentDao.getStudent(id);
		System.out.println(student);
		return student;
	}

	@Override
	public void addStudent(Student student) {
		studentDao.addStudent(student);
	}

	@Override
	public void updateStudent(Student student) {

		studentDao.updateStudent(student);
	}

	@Override
	public void deleteStudent(int id) {

		studentDao.deleteStudent(id);
	}


	@Override
	public List<String> selectHabits(int id) {
		
		return studentDao.selectHabits(id);
	}

}
