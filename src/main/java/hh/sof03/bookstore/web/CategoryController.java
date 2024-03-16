package hh.sof03.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.sof03.bookstore.domain.Book;
import hh.sof03.bookstore.domain.Category;
import hh.sof03.bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping(value = "/categorylist", method = RequestMethod.GET)
    public String listCategories(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        return "categorylist"; // categorylist.html
    }

    // lisää uusi kategoria
    @RequestMapping(value = "/addcat", method = RequestMethod.GET)
    public String addCategory(Model model) {
        model.addAttribute("category", new Category());
        //model.addAttribute("categories", categoryRepository.findAll());
        return "addcategory"; // addcategory.html
    }

    // uuden kateogorian tallentaminen
    @RequestMapping(value = "/savecat", method = RequestMethod.POST)
    public String saveCateogry(Category category) {
        categoryRepository.save(category);
        return "redirect:/categorylist";
    }
}
