# [二分搜索](src/binarySearch)
>1. 确定right 边界问题，如果right = nums.length, 那么循环条件:`left < right`;反之，right = nums.length - 1，那么循环条件就是：`left <= right`
>2. 确定 left 和 right 的变化规律。如果说 left 和 right 都在 mid 基础上 +1 或者 -1，最终结果优先选择left，其次选择right，
> 选择之前记得进行合法性校验，即是否在允许范围之内。如果说 left 和right 只变了一个，那么就选择变得那个。
>3. (1)和(2)一定要结合起来看，不要形成死循环。具体情况具体讨论。
>4. 返回值一定区分清楚，(1)和(2)说的不绝对，具体情况具体讨论
>5. 如果说最终结果可能会超出范围，那么就用left <= right。
>6. 优先考虑使用left 和right 都变的策略。如果说都变的策略不好写，那么在考虑只变一个的。