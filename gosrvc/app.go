// Copyright The OpenTelemetry Authors
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package main

import (
	"context"

	"go.opentelemetry.io/otel"
	"go.opentelemetry.io/otel/attribute"
	"go.opentelemetry.io/otel/codes"
	"go.opentelemetry.io/otel/trace"
)

// name is the Tracer name used to identify this instrumentation library.
const name = "custom"

// App is an Fibonacci computation application.
type App struct {
}

// NewApp returns a new App.
func NewApp() *App {
	return &App{}
}

// Run starts polling users for Fibonacci number requests and writes results.
func (a *App) Run(ctx context.Context) uint64 {
	var span trace.Span
	ctx, span = otel.Tracer(name).Start(ctx, "Quote", trace.WithSpanKind(trace.SpanKindServer))

	f := a.Write(ctx, 40)
	span.End()
	return f
}

// Write writes the n-th Fibonacci number back to the user.
func (a *App) Write(ctx context.Context, n uint) uint64 {
	var span trace.Span
	ctx, span = otel.Tracer(name).Start(ctx, "Prepare")
	defer span.End()

	f, _ := func(ctx context.Context) (uint64, error) {
		_, span := otel.Tracer(name).Start(ctx, "Calculate", trace.WithAttributes(attribute.String("foo", "bar")))
		defer span.End()
		f, err := Fibonacci(n)
		if err != nil {
			span.RecordError(err)
			span.SetStatus(codes.Error, err.Error())
		}
		return f, err
	}(ctx)
	return f
}
