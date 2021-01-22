package gzyz.Allmode.dao;

import gzyz.Allmode.pojo.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @author jun
 * @date 2021/1/21-10:27
 */
@Mapper
public interface CourseDao {
    public List<Course> queryCourse(String userId);
    public int addCourse(Course course);
    public int delCourseByName(@Param("courId") String courId);
    public int editCourseByName(@Param("courName") String courName,
                                @Param("courId") String courId);
    public List<Course> queryOnlyCourse(String userId);
    public Course queryCourseById(String courId);
}
