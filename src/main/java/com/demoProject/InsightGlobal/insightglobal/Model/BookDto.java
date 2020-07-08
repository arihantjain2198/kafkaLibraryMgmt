package com.demoProject.InsightGlobal.insightglobal.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BookDto {
    private Integer bookId;
    private String bookName;
    private String bookAuthor;

}
