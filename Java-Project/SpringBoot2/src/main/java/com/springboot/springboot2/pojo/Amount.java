package com.springboot.springboot2.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description = "账单信息")
public class Amount {

    @Schema(description = "账单主键，唯一标识")
    private Integer amountId;

    @Schema(description = "账单相关的业主")
    private Integer amountRoomId;

    @Schema(description = "账单类型，即费用类型的 id 主键")
    private Byte amountType;

    @Schema(description = "生成账单的时间")
    private LocalDateTime amountDate;

    @Schema(description = "需支付的费用，放大100倍，避免浮点数的误差")
    private Integer amount;

    @Schema(description = "账单支付状态: 1、已支付，2、未支付")
    private Integer isPaid;
}
