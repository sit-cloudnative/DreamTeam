package com.sit.cloudnative.SubjectListService.adapter;
public class Program{
   
    private long program_id;
    private String program_name;
    private String program_code;
    private String program_description;

    public Program() {

    }

    public long getProgram_id() {
        return this.program_id;
    }

    public void setProgram_id(long program_id) {
        this.program_id = program_id;
    }

    public String getProgram_name() {
        return this.program_name;
    }

    public void setProgram_name(String program_name) {
        this.program_name = program_name;
    }

    public String getProgram_code() {
        return this.program_code;
    }

    public void setProgram_code(String program_code) {
        this.program_code = program_code;
    }

    public String getProgram_description() {
        return this.program_description;
    }

    public void setProgram_description(String program_description) {
        this.program_description = program_description;
    }


}