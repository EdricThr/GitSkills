package com.thr.action;

import java.util.List;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
import com.thr.po.Student;
import com.thr.service.IStudentService;
import com.thr.service.impl.StudentServiceImpl;

public class StudentAction extends ActionSupport implements ModelDriven<Student>{

	private static final long serialVersionUID = 1L;
	
	private IStudentService studentService = new StudentServiceImpl();
	
	private Student student = new Student();
	
	public Logger logger=Logger.getLogger(StudentAction.class);
	
	Logger log = Logger.getLogger("ScriptMaint");
	
	
	/**
	 * 添加学生
	 * @return
	 */
	public String addStudent(){
		
		try {
			System.out.println("添加学生信息"+student);
			studentService.addStudent(student);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return selectAll();
	}

	/**
	 * 查询所有的学生
	 * @return
	 */
	public String selectAll(){
		
		try {
			List<Student> studentList = studentService.sellectAll();
			ActionContext.getContext().getContextMap().put("stuList", studentList);
			System.out.println(studentList);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return "list";
	}
	
	/**
	 * 通过id查询学生信息
	 * @return
	 */
	public String selectStudent(){
		
		System.out.println("进入通过id查询学生action，id"+student.getId());
		try {
			studentService.getStudent(student.getId());
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
		
	}
	/**
	 * 根据id查询爱好
	 * @return
	 */
	public String selectHabits(){
		
		try {
			List<String> habits = studentService.selectHabits(student.getId());
			System.out.println(habits);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
	/**
	 * 跳转到更改学生信息界面
	 * @return
	 */
	public String goUpdate(){
		
		Student stu = studentService.getStudent(student.getId());
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.pop();
		vs.push(stu);
		return "update";
	}
	
	public String goHabits(){
		Student stu = studentService.getStudent(student.getId());
		List<String> list = studentService.selectHabits(student.getId());
		stu.setHabit(list);
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.pop();
		vs.push(stu);
		return "habits";
	}
	
	/**
	 * 修改学生信息
	 * @return
	 */
	public String updateStudent(){
		try {
			studentService.updateStudent(student);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return selectAll();
	}
	/**
	 * 删除id为参数的学生
	 * @return
	 */
	public String deleteStudent(){
		try {
			studentService.deleteStudent(student.getId());
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return selectAll();
	}

	/**
	 * 测试log4j
	 */
	public void aim(){
		
		System.out.println("qian--------");
		new test().ttt();
		System.out.println("holu--------");
	}
	
	@Override
	public Student getModel() {
		return student;
	}
}
