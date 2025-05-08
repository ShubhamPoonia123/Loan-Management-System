package com.LMS.Loan.Management.System.controller;

import com.LMS.Loan.Management.System.dto.ReypaymentDTO;
import com.LMS.Loan.Management.System.dto.ReypaymentListDTO;
import com.LMS.Loan.Management.System.entity.Repayment;
import com.LMS.Loan.Management.System.service.RepaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/reypayment")
public class RepaymentController {

    @Autowired
    private RepaymentService repaymentService;

    @PostMapping ("/makeRepaymentBy/{loanId}")
    @PreAuthorize ("hasRole('ROLE_USER')")
    public ResponseEntity< ReypaymentDTO > makeRepayment( @PathVariable Integer loanId, @RequestParam Double amount) {
        Repayment repayment = repaymentService.makeRepayment(loanId, amount);
        return ResponseEntity.ok(new ReypaymentDTO (200, "Repayment successful", repayment));
    }

    @GetMapping("/getRepaymentHistoryBy/{loanId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public ResponseEntity< ReypaymentListDTO > getRepaymentHistory( @PathVariable Integer loanId) {
        List <Repayment> history = repaymentService.getRepaymentHistory(loanId);
        return ResponseEntity.ok(new ReypaymentListDTO (200, "Repayment history fetched", history));
    }

    @PutMapping("/overdue/update")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<ReypaymentDTO> updateOverdueLoans() {
        repaymentService.updateOverdueLoans();
        return ResponseEntity.ok(new ReypaymentDTO (200, "Overdue loans updated", null));
    }
}
