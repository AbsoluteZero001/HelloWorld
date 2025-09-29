package com.springboot.springboot2.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "费用消息，包括单价，计费方式")
public class FreightBasis {

    @Schema(description = "费用信息的标识")
    private Integer freightBasisId;

    @Schema(description = "费用单价")
    private Integer price;

    @Schema(description = "费用介绍")
    private String intro;

    @Schema(description = "费用名称")
    private String basisName;
}
