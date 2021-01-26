package gzyz.Allmode.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mysql.cj.x.protobuf.MysqlxConnection;
import gzyz.Allmode.pojo.Course;
import gzyz.Allmode.pojo.PageUtils;
import gzyz.Allmode.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * @author jun
 * @date 2021/1/21-10:41
 */
@Controller
public class CourseController {
    @Autowired
    CourseService courseService;

    /**
     *添加科目(OK)
     * @param course  courseName userId
     * @return
     */
    @RequestMapping("/question/type/addCourse")
    @ResponseBody
    public boolean addCourse( @RequestBody Course course){
        System.out.println(course);
        return courseService.addCourse(course);
    }

    /**
     * 查询科目(分页)  userId offSet pageNumber(OK)
     * @return
     */
    @RequestMapping("/question/type/queryCourse")
    @ResponseBody
    public PageUtils queryCourse(@RequestBody HashMap<String,String> map){
        Set<String> keySet = map.keySet();
        for (String s : keySet) {
            System.out.println(s+": "+map.get(s));
        }
        PageHelper.offsetPage(Integer.parseInt(map.get("offSet")),Integer.parseInt(map.get("pageNumber")));
        List<Course> allCourse = courseService.queryCourse(map.get("userId"));

        PageInfo<Course> pageInfo=new PageInfo<Course>(allCourse);
        return new PageUtils(new Long(pageInfo.getTotal()).intValue(),pageInfo.getList());
    }

    /**
     * 查询所有科目信息(OK)
     * @param course  (userId)
     * @return
     * {
     *     "courId":"937661-1"
     * }
     */
    @RequestMapping("/question/type/queryOnlyCourse")
    @ResponseBody
    public List<Course> queryOnlyCourse(@RequestBody Course course){
         System.out.println(course);
         return courseService.queryOnlyCourse(course.getUserId());
    }

    /**
     * 根据科目Id查询科目名(半OK)
     * @param course   (courId)
     * @return
     *??
     */
    @RequestMapping("/question/type/queryCourseById")
    @ResponseBody
    public String queryCourseById( Course course){
        System.out.println(course);
        Course course2 = courseService.queryCourseById(course.getCourId());
        if (course!=null){
            return course2.getCourName();
//            return "haha";
        }
        return "";
    }

    /**
     * 根据id删除科目（OK）
     * @param courId
     * @return
     */
    @RequestMapping("/question/type/delCourseByName/{courId}")
    @ResponseBody
    public boolean delCourseByName(@PathVariable("courId") String courId){
        System.out.println(courId);
        return courseService.delCourseByName(courId);
    }

    /**
     * 编辑科目信息(OK)
     * @param course CourName courId
     * @return
     */
    @RequestMapping("/question/type/editCourseByName")
    @ResponseBody
    public boolean editCourseByName(@RequestBody Course course){
        System.out.println(course);
        return courseService.editCourseByName(course);
    }
}
