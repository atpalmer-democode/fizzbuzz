#!/usr/bin/env perl

use strict;
use warnings;
use feature qw/say/;

sub get_or_empty {
    my $text = shift;
    my $test = \&{shift @_};
    return $test->() ? $text : '';
}

sub default_if_empty {
    my $textref = shift;
    my $default = shift;
    return length($$textref) ? $$textref : $default;
}

for (1..100) {
    my $fizz = get_or_empty fizz => sub { $_ % 3 == 0 };
    my $buzz = get_or_empty buzz => sub { $_ % 5 == 0 };
    my $fizzbuzz = bless \"$fizz$buzz";
    say $fizzbuzz->default_if_empty($_);
}
