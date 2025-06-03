package com.ecommerce.ProuductList.dto;




// IN dto we only show the useful information which are necessary do not show the unwnated information to the client like password , emial

import lombok.*;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor


public class CategoryDTO {

    private Long id ;
    private String name;
    private List<ProductDTO> products ;


}
