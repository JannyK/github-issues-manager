package no.softeam;

import org.springframework.social.github.api.GitHubIssue;

public class Issue {

	private String repo;
	private GitHubIssue githubIssue;

	public Issue(String repo, GitHubIssue githubIssue) {
		this.repo = repo;
		this.githubIssue = githubIssue;
	}

	public String getRepo() {
		return repo;
	}

	public GitHubIssue getGithubIssue() {
		return githubIssue;
	}
}