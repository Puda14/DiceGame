# DiceGame

## Rule

Cần lập trình 1 trò chơi như sau (trên 1 máy tính duy nhất):

- Số lượng người chơi: luôn là 4. Nếu có < 4 người chơi thật tham gia, máy tính sẽ tự động thêm 1 số người chơi ảo cho đủ 4 người.
- Có 4 quân súc sắc. Mỗi quân súc sắc, xác suất cho 1 mặt là 20%, các mặt còn lại là 16% (lần lượt 4 quân cho các mặt 1, 2, 3, 4 chấm)
- Mỗi người chơi ít nhất có các thuộc tính và hành vi cơ bản sau:
  - Tên
  - Số điểm đang có
  - Riêng người chơi ảo có thêm cách thức biểu lộ thất bại khác nhau. (Lưu ý có tối đa 4 người chơi ảo)
- Có 1 trọng tài, điều khiển cuộc chơi. Trọng tài có nhiệm vụ:

  - Chỉ định người chơi tiếp theo.
  - Tính điểm cho người chơi.

    - Nếu tổng điểm cũ và điểm vừa gieo của 1 người chơi là 21 → thắng cuộc, kết thúc cuộc chơi.

    - Nếu điểm cũ + điểm vừa gieo lớn hơn 21 → tính điểm của người chơi là 0. Trường hợp còn lại, cộng điểm bình thường.

  - Tuyên bố người thắng cuộc. Những người chơi ảo thua cuộc sẽ lần lượt thực hiện cách thức biểu lộ thất bại của mình.

- Mỗi người chơi, khi đến lượt, sẽ nhận ngẫu nhiên 1 quân súc sắc và gieo

## Probability

Xác suất tích lũy là xác suất của sự kiện đó và tất cả các sự kiện trước đó trong không gian mẫu. Nó thường được sử dụng để quy định xác suất của một biến ngẫu nhiên nhỏ hơn hoặc bằng một giá trị cụ thể.

Công thức xác suất tích lũy (cumulative probability) của một biến ngẫu nhiên $X$ tại giá trị $x$ được ký hiệu là $P(X \leq x)$ và được tính bằng tổng xác suất của tất cả các giá trị nhỏ hơn hoặc bằng $x$.
