package com.winism.winism.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SingleResult<T> extends com.winism.winism.model.response.CommonResult {
    private T data;
}