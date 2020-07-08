package com.demoProject.InsightGlobal.insightglobal.Model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LibraryEventDto {

    private Integer libraryEventId;
    private LibraryEventType libraryEventType;
    private BookDto bookDto;


}
