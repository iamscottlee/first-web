package com.exampl.web;

import com.exampl.mapper.TStudentMapper;
import com.exampl.model.TStudent;
import com.exampl.model.TStudentExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.log4j.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.support.HttpRequestHandlerServlet;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Locale;

@Controller
public class TStudentController {
    @Autowired
    TStudentMapper tstudentmapper;


    @RequestMapping(value = "/addTStudent", method = RequestMethod.POST)
    public String addTStudent(HttpServletRequest request,
                              String stuname,
                              Double age,
                              String sex,
                              String gradename) {

        String name = request.getParameter("stuname");

        TStudent t = new TStudent();
        t.setStuname(stuname);
        t.setAge(age);
        t.setSex(sex);
        t.setGradename(gradename);
        tstudentmapper.insert(t);
        return "redirect:listTStudent";
    }

    @RequestMapping("/deleteTStudent")
    public String deleteTStudent(double id) throws Exception {
        tstudentmapper.deleteByPrimaryKey(id);
        return "redirect:listTStudent";
    }

    @RequestMapping("/updateTStudent")
    public String updateTStudent(TStudent t) throws Exception {
        tstudentmapper.updateByPrimaryKeySelective(t);
        return "redirect:listTStudent";
    }

    @RequestMapping("/editTStudent")
    public String listCategory(Double id, Model m) throws Exception {
        TStudent t = tstudentmapper.selectByPrimaryKey(id);
        m.addAttribute("t", t);
        return "editStudent";
    }

    @RequestMapping("/listTStudent")
    public String listTStudent(Model m, @RequestParam(value = "start", defaultValue = "0") int start,
                               @RequestParam(value = "size", defaultValue = "5") int size)
            throws Exception {
        PageHelper.startPage(start, size, "id desc");
        /////
        TStudentExample example = new TStudentExample();
        //TStudentExample.Criteria criteria=example.createCriteria();
        List<TStudent> cs = tstudentmapper.selectByExample(example);
        /////
        PageInfo<TStudent> page = new PageInfo<>(cs);
        m.addAttribute("page", page);
        return "listStudent";
    }

}
