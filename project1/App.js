import React from 'react';
import { StyleSheet, Text, View } from 'react-native';
import { Entypo } from '@expo/vector-icons';

export default function App() {
  return (
    <View style={styles.item}>
      <Entypo name='home' size={58} color='#333' />
      <View style={styles.container}>
          <View style={StyleSheet.header}>
            <Text style={styles.headline}>Name</Text>
          </View>
      </View>
      <View style={styles.container1}>
        <View style={styles.item1}>
        <Entypo name='menu' size={58} color='#333' />
        </View>
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
    top: 0,
    right:0,

  },
  container1: {
    top: -60,
    right: -350,
  },
  headline: {
    fontWeight: 'bold',
    fontSize: 30,
  marginTop: -45,
    width: 90,
  },
});

