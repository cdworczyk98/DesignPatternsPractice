🔥 Your Challenge

Extend the system with:

1️⃣ Add a "FraudCheckStrategy"

Some payments require fraud checks (credit card does, Bitcoin doesn't).

But do NOT modify existing classes heavily.

Hint:

You may need a second strategy

Or combine strategies

Or use composition

2️⃣ Add Discount Logic

Different payment methods apply different discounts:

Credit Card → 2%

PayPal → 3%

Bitcoin → 5%

Try to:

Avoid if statements

Keep Open/Closed principle

🧠 Deep Thinking Question

After implementing both fraud checking and discount logic:

👉 Do you still have only one reason to change PaymentProcessor?

If yes → Good design
If no → You may need another pattern 😉