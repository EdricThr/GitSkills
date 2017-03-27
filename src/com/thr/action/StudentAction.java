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
	 * ���ѧ��
	 * @return
	 */
	public String addStudent(){
		
		try {
			System.out.println("���ѧ����Ϣ"+student);
			studentService.addStudent(student);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return selectAll();
	}

	/**
	 * ��ѯ���е�ѧ��
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
	 * ͨ��id��ѯѧ����Ϣ
	 * @return
	 */
	public String selectStudent(){
		
		System.out.println("����ͨ��id��ѯѧ��action��id"+student.getId());
		try {
			studentService.getStudent(student.getId());
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
		
	}
	/**
	 * ����id��ѯ����
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
	 * ��ת������ѧ����Ϣ����
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
	 * �޸�ѧ����Ϣ
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
	 * ɾ��idΪ������ѧ��
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
	 * ����log4j
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
