//package com.sprint;
//
//import org.junit.Test;
//import org.junit.jupiter.api.DisplayName;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.web.servlet.MockMvc;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.sprint.models.Customer;
//import com.sprint.repository.CustomerRepository;
//import com.sprint.service.CustomerService;
//
//public class CustomerControllerTest {
//
//		@Autowired
//		private MockMvc mockMvc;
//		
//		@MockBean
//		private CustomerService customerService;
//		
//		@Autowired
//		private ObjectMapper objectMapper;
//		@MockBean
//		private Customer customer;
//		@MockBean
//		private CustomerRepository customerRepository;
//		@DisplayName("JUnit test for getEmployeeById method")
//	    @Test
//	    public Customer givenEmployeeId_whenGetEmployeeById_thenReturnEmployeeObject(Object customerRepository){
//	        // given
//	        given(((CustomerRepository) customerRepository).findCustomerById(1L)).willReturn(Optional.of(customer));
//	
//	        // when
//	        Customer savedEmployee = customerService.findCustomerById(customer.getCustomerId()).get();
//	      
//      // then
//      assertThat(savedEmployee).isNotNull();
//
//  }
////	private Object given(Customer findCustomerById) {
////		// TODO Auto-generated method stub
////		return null;
////	}
//	}
//
//}
