package com.moblog.dev;

import java.util.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BlogController {
    private List<Blog> blogs;

    public BlogController() {
        blogs = new ArrayList<>();
    }

    @GetMapping({ "/", "/blogs" })
    public String blogs(Model model) {
        model.addAttribute("blogs", blogs);
        return "blogs";
    }

    @GetMapping({ "/blog" })
    public String blog(@RequestParam int id, Model model) {
        var blog = blogs.get(id);
        model.addAttribute("blog", blog);
        return "blog";
    }

    @GetMapping({ "/add-blog" })
    public String addBlog() {
        return "add-blog";
    }

    // @PostMapping({ "/add-blog" })
    // public void addBlog(HttpServletRequest request, PrintWriter pw) {
    // String heading = request.getParameter("heading");
    // String description = request.getParameter("description");

    // pw.println(heading);
    // pw.println(description);
    // }
    @PostMapping({ "/add-blog" })
    public String addBlog(@ModelAttribute Blog blog) {
        blogs.add(blog);
        return "redirect:/blogs";// treated as controller(redirect to blogs controller not html page)

    }
}
