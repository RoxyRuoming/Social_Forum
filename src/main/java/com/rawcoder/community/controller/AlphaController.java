package com.rawcoder.community.controller;

import com.rawcoder.community.dao.AlphaDao;
import com.rawcoder.community.service.AlphaService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@Controller
public class AlphaController {
    @Autowired
    private AlphaService alphaService;

    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello() {
        return "Hello Spring Boot.";
    }

    @RequestMapping("/data")
    @ResponseBody
    public String getData() {
        return alphaService.find();
    }
    @RequestMapping("/http")
    public void http(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // acquire request data
        System.out.println(request.getMethod());
        System.out.println(request.getServletPath());
        Enumeration<String> enumeration = request.getHeaderNames();
        while (enumeration.hasMoreElements()) {
            String name = enumeration.nextElement();
            String value = request.getHeader(name);
            System.out.println(name + ": " + value);
        }
        System.out.println(request.getParameter("code"));

        // return response data
        response.setContentType("text/html;charset=utf-8");
        try(PrintWriter writer = response.getWriter();){
            writer.write("<h1> raw coder go go go! </h1>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // GET - get information from the server
    @RequestMapping(path = "/students", method = RequestMethod.GET)
    @ResponseBody
    public String getStudents(
            @RequestParam(name = "current", required = false, defaultValue = "1") int current,
            @RequestParam(name = "limit", required = false, defaultValue = "10") int limit ) {
        System.out.println(current);
        System.out.println(limit);
        return "some students";
    }

    // /student/123 (a way of passing parameters - put the parameters in the path)
    @RequestMapping(path = "/student/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getStudent(@PathVariable("id") int id) {
        System.out.println(id);
        return "a student";
    }

    // Post (GET has limits while passing data)
    @RequestMapping(path = "/student", method = RequestMethod.POST)
    @ResponseBody
    public String saveStudent(String name, int age) {
        System.out.println(name);
        System.out.println(age);
        return "success";
    }

    // Respond html data (no @ResponseBody - default respond html )
    @RequestMapping(path = "/teacher", method = RequestMethod.GET)
    public ModelAndView getTeacher() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("name", "Roxy");
        mav.addObject("age", "27");
        mav.setViewName("/demo/view");
        return mav;
    }

    // another easier way to respond html data
    @RequestMapping(path = "/school", method = RequestMethod.GET)
    public String getSchool(Model model) {
        model.addAttribute("name", "NEU");
        model.addAttribute("age", "124");
        return "/demo/view";
    }

    // Respond JSON (asynchronous request);
    // asynchronous request - no page refresh
    // Java object -> JSON -> JS object
    @RequestMapping(path = "/emp", method = RequestMethod.GET)
    @ResponseBody // (if no @ResponseBody, the browser will return html)
    public Map<String, Object> getEmp() {
        Map<String, Object> emp = new HashMap<>();
        emp.put("name", "Stella");
        emp.put("age", "25");
        emp.put("salary", "10000");
        return emp;
    }

    @RequestMapping(path = "/emps", method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String, Object>> getEmps() {
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> emp = new HashMap<>();
        emp.put("name", "Stella");
        emp.put("age", "25");
        emp.put("salary", "10000");
        list.add(emp);

        emp = new HashMap<>();
        emp.put("name", "Becky");
        emp.put("age", "24");
        emp.put("salary", "8000");
        list.add(emp);

        emp = new HashMap<>();
        emp.put("name", "Lily");
        emp.put("age", "20");
        emp.put("salary", "6000");
        list.add(emp);

        return list;
    }


}
