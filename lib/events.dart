import 'package:flutter/services.dart';

const _channel = const EventChannel('events');

typedef void Listener(dynamic msg);
typedef void CancelListening();

CancelListening startListening(Listener listener) {
  var subscription = _channel.receiveBroadcastStream(
  ).listen(listener, cancelOnError: true);
  return () {
    subscription.cancel();
  };
}