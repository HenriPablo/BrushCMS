/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bap.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author tomek
 */
@Controller
public class AdminController {


	@RequestMapping("/admin/index.html")
	public final ModelAndView adminIndex( ModelMap model ){
		ModelAndView mov = new ModelAndView();
		model.addAttribute("section", "index");
		model.addAttribute("page", "index");
		mov.setViewName("/admin/layout");
		return mov;
	}

}
