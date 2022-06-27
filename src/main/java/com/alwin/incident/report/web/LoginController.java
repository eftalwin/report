/**
 * 
 */
package com.alwin.incident.report.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.alwin.incident.report.data.models.Incident;
import com.alwin.incident.report.data.payloads.ReportRequest;
import com.alwin.incident.report.service.IncidentReportService;

/**
 * @author anubi
 *
 */
@Controller
public class LoginController {


  @Autowired
  IncidentReportService incidentReportService;

  private String loginName;

  @GetMapping("")
  public String viewHomePage() {
    return "index";
  }

  @GetMapping("/healthcheck")
  public String healthCheck() {
    return "Application Health Check is ok";
  }


  @GetMapping("/all")
  public String listIncidents(Model model) {
    model.addAttribute("incidents", incidentReportService.getAllIncidents());
    return "incidents";
  }

  @GetMapping("/myincidents")
  public String listMyIncidents(Model model) {
    model.addAttribute("incidents", incidentReportService.getAllIncidents());
    return "myincidents";
  }

  @GetMapping("/newincident")
  public String showAddIncidentForm(Model model) {
    model.addAttribute("incident", new Incident());
    return "addincident_form";
  }

  @PostMapping("/add")
  public String saveStudent(@ModelAttribute("incident") ReportRequest incident) {
    incidentReportService.createIncident(incident);
    return "incidentreport_success";
  }

  @GetMapping("/delete/{id}")
  public String deleteIncident(@PathVariable("id") Integer id) {
    incidentReportService.deleteIncident(id);
    return "redirect:/myincidents";
  }

  @GetMapping("/update/{id}")
  public String updateIncident(@PathVariable Integer id, Model model) {
    model.addAttribute("incident", incidentReportService.getASingleIncident(id));
    return "editincident";
  }

  @PostMapping("/update/{id}")
  public String updateIncident(@PathVariable Integer id,
      @ModelAttribute("incident") Incident incident, Model model) {
    incidentReportService.updateIncident(incident);
    return "redirect:/myincidents";
  }

  public String getLoginName() {
    return loginName;
  }

  public void setLoginName(String loginName) {
    this.loginName = loginName;
  }

}
