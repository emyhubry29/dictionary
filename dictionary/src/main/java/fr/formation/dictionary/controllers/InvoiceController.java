package fr.formation.dictionary.controllers;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.dictionary.business.Invoice;

@RestController
@RequestMapping("/invoices") // mapping = mise en correspondance de 2 chose
public class InvoiceController {

    @GetMapping("/{id}")
    public Invoice invoice(@PathVariable("id") Long id) { // Long objet = null
	LocalDate date = LocalDate.of(2019, 12, 26);
	Invoice invoice = new Invoice("A01", date, 1005.36);
	invoice.setId(id);
	return invoice;
    }

    @GetMapping()
    public ArrayList<Invoice> getAll(@RequestParam("size") int size,
	    @RequestParam("page") int page) {
	System.out.println("size=" + size + ", page=" + page);
	LocalDate date = LocalDate.of(2019, 12, 26);
	ArrayList<Invoice> invoices = new ArrayList<>();
	Invoice first = new Invoice("A01", date, 1005.36);
	invoices.add(first);
	Invoice second = new Invoice("A02", date, 233355.36);
	invoices.add(second);
	return invoices;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
	System.out.println("Delete invoice with id " + id);
    }
    // public ArrayList<Invoice> invoices(){

    @PostMapping()
    public void create(@RequestBody @Valid Invoice invoice) {
	System.out.println(invoice);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Long id,
	    @RequestBody Invoice invoice) {
	System.out.println(invoice);
    }

    @PatchMapping("/{id}/paid")
    public void paid(@PathVariable("id") Long id) {
	System.out.println("patched invoice with id " + id);
    }
}
