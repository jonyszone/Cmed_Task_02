package com.assesment.cmedtask02;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Wand {

@SerializedName("wood")
@Expose
private String wood;
@SerializedName("core")
@Expose
private String core;
@SerializedName("length")
@Expose
private Double length;

public String getWood() {
return wood;
}

public void setWood(String wood) {
this.wood = wood;
}

public String getCore() {
return core;
}

public void setCore(String core) {
this.core = core;
}

public Double getLength() {
return length;
}

public void setLength(Double length) {
this.length = length;
}

}