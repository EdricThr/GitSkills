package com.thr.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.log4j.Logger;

import com.thr.dao.IStudentDao;
import com.thr.po.Student;
import com.thr.service.utils.INFO;
import com.thr.service.utils.JdbcUtils;

public class StudentDaoImpl implements IStudentDao {

	
	public Logger logger=Logger.getLogger(StudentDaoImpl.class);
	@Override
	public List<Student> sellectAll() {
		
		String sql = "select * from student";
		try {
			return JdbcUtils.getQuerrRunner().query(sql, new BeanListHandler<Student>(Student.class));
		} catch (SQLException e) {
			logger.error("error", e);
			throw new RuntimeException(e);
		}
	}

	@Override
	public Student getStudent(int id) {
		
		System.out.println("进入通过id查询学生dao");
//		String sql = "SELECT * FROM habits LEFT JOIN student ON habits.sid = student.id And student.id=?";
		String sql = "select * from student where id=?";
		try {
			return JdbcUtils.getQuerrRunner().query(sql, new BeanHandler<Student>(Student.class),id);
		} catch (SQLException e) {
			logger.error("error", e);
			throw new RuntimeException(e);
		}
	}

	@Override
	public void addStudent(Student student) {
		
		String sql = "INSERT INTO student(username,age,TIME) VALUES(?,?,?);";
		try {
			JdbcUtils.getQuerrRunner().update(sql, student.getUsername(),student.getAge(),student.getTime());
		} catch (SQLException e) {
			logger.error(INFO.INFO_ADD,e);
			throw new RuntimeException(e);
		}
	}

	@Override
	public void updateStudent(Student student) {

		String sql = "update student set username=?,age=?,time=? where id=?"; 
		try {
			JdbcUtils.getQuerrRunner().update(sql, student.getUsername(),student.getAge(),student.getTime(),student.getId());
		} catch (SQLException e) {
			logger.error(INFO.INFO_UPDATE,e);
			throw new RuntimeException(e);
		}
	}

	@Override
	public void deleteStudent(int id) {

		System.out.println("进入通过id删除学生dao");
		String sql = "delete from student where id=?";
		try {
			JdbcUtils.getQuerrRunner().update(sql,id);
		} catch (SQLException e) {
			logger.error(INFO.INFO_DELETE,e);
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<String> selectHabits(int id) {
		System.out.println("通过id查询爱好：id" + id);
		String sql = "SELECT habit FROM habits h,student s WHERE h.sid=s.id and s.id=?";
		try {
			List<Map<String,Object>> maplist = JdbcUtils.getQuerrRunner().query(sql, new MapListHandler(),id);
			System.out.println(maplist);
			List<String> list = new ArrayList<String>();
			for (int i = 0; i < maplist.size(); i++) {
				list.add(maplist.get(i).get("habit").toString());
			}
			System.out.println("查询到爱好："+list);
			return list;
		} catch (SQLException e) {
			logger.error(INFO.INFO_HABITS,e);
			throw new RuntimeException(e);
		}
	}
	
/*	@Override
	public List<String> selectHabits(int id) {
		System.out.println("通过id查询爱好：id" + id);
//		String sql = "SELECT habit FROM habits LEFT JOIN student ON habits.sid = student.id where student.id=?";
		String sql = "SELECT habit FROM habits h,student s WHERE h.sid=s.id";
		try {
			List<Habit> list = JdbcUtils.getQuerrRunner().query(sql, new BeanListHandler<Habit>(Habit.class));
			System.out.println(list);
			return null;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}*/

}
