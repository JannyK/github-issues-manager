package no.softeam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotypes.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IssueController {

	private IssueManager issueManager;

	@Autowired
	public IssueController(IssueManager issueManager) {
		this.issueManager = issueManager;
	}

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("issues", issueManager.findOpenIssues());
		return "index";
	}
}