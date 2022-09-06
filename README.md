# inline-conversion-error-reproduction
Reproduction of Unquote conversion subclass error

With Scala 3 using `inline` in some cases you can actually get the compiler to synthesize invalid code. Here's a case in point that seems to only be reproducible with an inline implicit conversion.
The relevance is that this is exactly how I do Quotation.
(Seems fixed in 3.2.0)

Probably should this as a sort of spec-proof to Quill proper when moving to 3.2.0.
