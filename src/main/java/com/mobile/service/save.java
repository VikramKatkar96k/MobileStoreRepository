package com.mobile.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.entity.MobileEty;
import com.mobile.respo.mobileresp;

@Service
public class save {
	@Autowired
	private mobileresp mobileresp;

	public save(mobileresp mobileresp) {
		this.mobileresp = mobileresp;
	}

//	@Bean
	public void Savemethod() {
		MobileEty obj = new MobileEty();
		obj.setId(105);
		obj.setName("Samsung");
		obj.setPrice(19500.00);
		obj.setRam(8);
		obj.setColour("white");
		mobileresp.save(obj);
		System.out.println(" -----Save Method excuited----- ");
	}

//	@Bean
	public void saveMultipleMobile() {
		MobileEty obj = new MobileEty();
		obj.setId(2);
		obj.setName("OnePlus");
		obj.setPrice(27500.00);
		obj.setRam(12);
		obj.setColour("gold");

		MobileEty obj1 = new MobileEty();
		obj1.setId(3);
		obj.setName("Xiaomi");
		obj.setPrice(12500.00);
		obj.setRam(6);
		obj.setColour("black");
		List<MobileEty> listobj = Arrays.asList(obj, obj1);
		mobileresp.saveAll(listobj);
	}

	public void findMethod() {
		Optional<MobileEty> findById = mobileresp.findById(105);
		if (findById.isPresent()) {
			MobileEty mobileEty = findById.get();
			System.out.println(mobileEty);
		}

	}

	public void findAllId() {
		List<Integer> list = Arrays.asList(1, 105, 3, 7, 2);
		Iterable<MobileEty> iterable = mobileresp.findAllById(list);
//		iterable.forEach(System.out::println);
		iterable.forEach(e -> System.out.println(e));

	}

	// @Bean
	public void fillAllrecord() {
		Iterable<MobileEty> findAll = mobileresp.findAll();
		findAll.forEach(System.err::println);
	}

//	@Bean
	public void countjpa() {
		var count = mobileresp.count();
		System.out.println(count);
	}

//	@Bean
	public void existid() {
		boolean check = mobileresp.existsById(105);
		System.out.println(check);
	}

//	@Bean
	public void DeleteID() {
		mobileresp.deleteById(3);
		System.out.println("deleted Scccessfully");
	}

//	@Bean
	public void deleteMutipleid() {
		List<Integer> list = Arrays.asList(105, 102, 3, 5);
		mobileresp.deleteAllById(list);
		System.out.println("deleted data ");
	}

//	@Bean
	public void deleteobj() {

		mobileresp.deleteAll();
		System.out.println("table truncate");
	}

//	@Bean
	public void deleteEntObj() {
		MobileEty ety = new MobileEty();
		ety.setId(105);
		mobileresp.delete(ety);
		System.err.println("deleted");
	}

//	@Bean
	public void deleteAll() {
		MobileEty obe1 = new MobileEty();
		obe1.setId(2);
		MobileEty obe2 = new MobileEty();
		obe2.setId(3);
		List<MobileEty> list = Arrays.asList(obe1, obe2);
		mobileresp.deleteAll(list);

	}
}
