package com.springboot.springboot2.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description = "支付信息")
public class Pay {

    @Schema(description = "支付信息的唯一标识")
    private Integer payId;

    @Schema(description = "支付费用的业主ID")
    private Integer payRoomId;

    @Schema(description = "支付的费用")
    private Double pay;

    @Schema(description = "支付的时间")
    private LocalDateTime payDate;

    @Schema(description = "支付的费用类型，即费用主键")
    private Integer payType;
}
