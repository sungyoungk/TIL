package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RateDiscountPolicyTest {

    DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10퍼센트 할인이 적용되어야 한다")
    void VIP_o() {
        //given
        Member member = new Member(1L,"memberA", Grade.VIP);

        //when
        int discount= discountPolicy.discount(member, 10000);
        //then
        Assertions.assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 테스트가 실패해야 한다")
    void vip_x(){
        //given
        Member member = new Member(2L,"memberA", Grade.BASIC);

        //when
        int discount= discountPolicy.discount(member, 10000);
        //then
        Assertions.assertThat(discount).isEqualTo(0);
    }



}