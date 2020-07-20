-- 뷰 : SIMPLE_ORDER_INFO
-- 페이징 처리를 위한 순번, 주문번호, 매장번호, 매장이름, 주문금액, 주문요청시간, 주문상태, 주문에 들어간 전체 아이템 수량, 대표 피자(첫번째 피자명+사이즈+도우), 대표사이드(첫번째 사이드명), 대표기타메뉴(첫번째 기타메뉴명)
CREATE VIEW simple_order_info
AS SELECT ROW_NUMBER() OVER(ORDER BY O.order_no) AS RN, O.order_no, O.branch_no, B.branch_name, O.order_discount_price, O.order_request_time, O.order_status,
     ((SELECT COUNT(order_no) FROM pizza_orders PO WHERE PO.order_no = O.order_no) 
     + (SELECT COUNT(order_no) FROM side_orders SO WHERE SO.order_no = O.order_no)
     + (SELECT COUNT(order_no) FROM etc_orders EO WHERE EO.order_no = O.order_no)) AS total_count,
    (SELECT PI.pizza_name || PI.pizza_size || '(' || PI.dough_name || ')'
	 FROM orders O, (SELECT PO.pizza_size, PO.pizza_order_amount, P.pizza_name, D.dough_name
    				 FROM orders O, pizza_orders PO, pizzas P, doughs D
    				 WHERE O.order_no = 100
    				 AND PO.order_no = O.order_no 
     				 AND P.pizza_no = PO.pizza_no 
     				 AND PO.dough_no = D.dough_no) PI 
     WHERE order_no = 100 AND rownum = 1) AS pizza_name, 
    (SELECT S.side_name FROM orders O, side_orders SO, sides S WHERE O.order_no = 100 AND SO.order_no = O.order_no AND SO.side_no = S.side_no AND rownum = 1) AS side_name,
    (SELECT E.etc_name FROM orders O, etc_orders EO, etcs E WHERE O.order_no = 100 AND EO.order_no = O.order_no AND EO.etc_no = E.etc_no AND rownum = 1) AS etc_name
FROM orders O, branches B
WHERE O.branch_no = B.branch_no;

commit;