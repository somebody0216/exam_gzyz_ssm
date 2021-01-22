package gzyz.Allmode.service;

import gzyz.Allmode.pojo.Course;

import java.util.List;

/**
 * @author jun
 * @date 2021/1/21-10:26
 */

public interface CourseService {
    public boolean addCourse(Course course);
    public List<Course> queryCourse(String userId);
    public boolean delCourseByName(String courId);
    public boolean editCourseByName(Course course);
    public List<Course> queryOnlyCourse(String userId);
    public Course queryCourseById(String courId);
}
