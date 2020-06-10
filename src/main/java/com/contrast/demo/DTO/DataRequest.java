package com.contrast.demo.DTO;

import com.contrast.demo.Entities.Organisation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DataRequest {

    private Organisation orgnisation;
}
