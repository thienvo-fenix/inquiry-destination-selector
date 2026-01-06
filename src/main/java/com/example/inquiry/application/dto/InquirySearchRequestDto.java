package com.example.inquiry.application.dto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Inquiry Destination Search Request DTO
 * 問合せ先検索リクエスト
 * 
 * Validation rules based on screen field definition:
 * - 問合せ先名称: 文字種=全角半角, 最大桁=100
 * - 問合せ先名称カナ: 文字種=全角半角, 最大桁=200
 * - 電話番号: 文字種=半角, 最大桁=13
 * - URL: 文字種=半角, 最大桁=256
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InquirySearchRequestDto {
    
    /**
     * 問合せ先名称 (全角半角, 最大100桁)
     */
    @Size(max = 100, message = "問合せ先名称は100文字以内で入力してください。")
    private String inquiryDestinationName;
    
    /**
     * 問合せ先名称カナ (全角半角, 最大200桁)
     */
    @Size(max = 200, message = "問合せ先名称カナは200文字以内で入力してください。")
    private String inquiryDestinationKana;
    
    /**
     * 電話番号 (半角数字とハイフンのみ, 最大13桁)
     */
    @Size(max = 13, message = "電話番号は13文字以内で入力してください。")
    @Pattern(regexp = "^[0-9\\-]*$", message = "電話番号は半角数字とハイフンのみで入力してください。")
    private String phoneNumber;
    
    /**
     * URLアドレス (半角のみ, 最大256桁)
     */
    @Size(max = 256, message = "URLは256文字以内で入力してください。")
    @Pattern(regexp = "^[\\x20-\\x7E]*$", message = "URLは半角で入力してください。")
    private String urlAddress;
    
    /**
     * 地域コードリスト
     */
    private List<String> regionCodes;
}
