package com.example.demo.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Worker;
import com.example.demo.repository.WorkerRepository;

@RestController()
@RequestMapping("/worker")
public class WorkerController {
	@Autowired
	private WorkerRepository workerRepository;
	
	@GetMapping("/showWorker")
	public Worker showWorker() {
		return this.workerRepository.getWorker(1);
	}
	
	@GetMapping("/all/showWorkers")
	public List<Worker> showWorkers() {
		return this.workerRepository.getWorkers();
	}
	
	@GetMapping("/create")
	public String create() {
		this.workerRepository.add(new Worker(1, "Nik", "Jasaiwal", 5000, Date.valueOf("2022-04-10"), "New","mail@gmail"));
		return "Worker created";
	}
	
	@GetMapping("/update")
	public String update() {
		this.workerRepository.update(new Worker(2, "Pranat", "Sharma", 10000, Date.valueOf("2022-04-11"), "Admin","newgmail.com"));
		return "Worker Updated";
	}
	
	@GetMapping("/delete")
	public String delete() {
		this.workerRepository.delete(1);
		return "Worker Deleted";
	}
}