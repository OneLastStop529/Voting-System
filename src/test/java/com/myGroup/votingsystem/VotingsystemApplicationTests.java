package com.myGroup.votingsystem;

import com.myGroup.votingsystem.entity.Citizen;
import com.myGroup.votingsystem.entity.Candidate;
import com.myGroup.votingsystem.repositories.CandidateRepo;
import com.myGroup.votingsystem.repositories.CitizenRepo;
import com.myGroup.votingsystem.controller.VotingController;
import com.sun.net.httpserver.HttpContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import java.io.IOException;

import javax.servlet.http.HttpSession;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VotingsystemApplicationTests {

	@Autowired
	VotingController votingController;
	CandidateRepo candidateRepo;
	CitizenRepo citizenRepo;
	Citizen citizen =  new Citizen();
	Candidate candidate;
	private HttpServletRequest context;

	@Test
	public void ValidVoterLogin() {
		String voterName = "Nouman";
		HttpSession session = context.getSession(true);

//		public String doLogin(@RequestParam String name, Model model, HttpSession session)
//		public String voteFor(@RequestParam Long id, HttpSession session)
		String response = votingController.doLogin(voterName, (Model) citizen, session);
		if(response != null)
		{
			System.out.println("Test Passed");
		}
	}

	@Test
	public void InvalidVoterLogin() {
		String voterName = "TestVoter";
		HttpSession session = context.getSession(true);

//		public String doLogin(@RequestParam String name, Model model, HttpSession session)
//		public String voteFor(@RequestParam Long id, HttpSession session)
		String response = votingController.doLogin(voterName, (Model) citizen, session);
		if(response != null)
		{
			System.out.println("Test Passed");
		}
	}

	@Test
	public void voteForValid() {
		double id = 2;
		HttpSession session = context.getSession(true);

//		public String doLogin(@RequestParam String name, Model model, HttpSession session)
//		public String voteFor(@RequestParam Long id, HttpSession session)
		String response = votingController.voteFor((long) id, session);
		if(response != null)
		{
			System.out.println("Test Passed");
		}
	}

	@Test
	public void voteForValidCandidate() {
		int id = 2;
		HttpSession session = context.getSession(true);

//		public String doLogin(@RequestParam String name, Model model, HttpSession session)
//		public String voteFor(@RequestParam Long id, HttpSession session)
		String response = votingController.voteFor((long) id, session);
		if(response != null)
		{
			System.out.println("Test Passed");
		}
	}
}
