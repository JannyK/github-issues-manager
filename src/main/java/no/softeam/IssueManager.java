package no.softeam;

import java.util.ArrayList;
import java.util.List;

import org.springframework.social.github.api.GithubIssue;
import org.springframework.social.github.api.impl.GithubTemplate;
import org.springframework.stereotype.Service;

@Service
public class IssueManager {

	String githubToken = "ccdbf257f052a594a0e7bd2823a69ae38a48ffb1";

	String org = "spring-projects";
	String[] repos = new String[] {"spring-boot", "spring-boot-issues"};

	GithubTemplate githubTemplate = new GithubTemplate(githubToken);

	public List<Issue> findIÓpenIssues() {
		List<Issue> openIssues = new ArrayList<>();

		for (String repo: repos) {
			final List<GithubIssue> issues = githubTemplate
				.repoOperations().getIssues(org, repo);

			for (GithubIssue issue: issues) {
				if (issue.getState().equals("open")) {
					openIssues.add(new Issue(repo, issue));
				}
			}
		}
		return openIssues;
	}
}
