package gzyz.Allmode.service.Impl;

import gzyz.Allmode.dao.CourseDao;
import gzyz.Allmode.pojo.Course;
import gzyz.Allmode.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author jun
 * @date 2021/1/21-10:39
 */
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseDao courseDao;
    int i=0;
    SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 添加科目
     * @param course
     * @return
     */
    @Override
    public boolean addCourse(Course course) {
        List<Course> courseList = queryCourse(course.getUserId());
        for (Course c : courseList) {
            System.out.println(c);
            if (c.getCourName().equals(course.getCourName())){//科目名重复，添加失败
                return false;
            }
        }
        i++;
        course.setCourId(course.getCourName().hashCode()+"-"+i);
        course.setIsDelete(0);
        course.setCreateTime(dateFormat.format(new Date()));
        return courseDao.addCourse(course)==1;
    }

    @Override
    public List<Course> queryCourse(String userId) {
        List<Course> courseList = courseDao.queryCourse(userId);
        return courseList;
    }

    @Override
    public boolean delCourseByName(String courId) {
        return courseDao.delCourseByName(courId)==1?true:false;
    }

    @Override
    public boolean editCourseByName(Course course) {
        return courseDao.editCourseByName(course.getCourName(),course.getCourId())==1?true:false;
    }

    @Override
    public List<Course> queryOnlyCourse(String userId) {
        return courseDao.queryOnlyCourse(userId);
    }

    @Override
    public Course queryCourseById(String courId) {
        return courseDao.queryCourseById(courId);
    }
}
