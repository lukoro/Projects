using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Saw : MonoBehaviour
{
    [SerializeField] public float rotationSpeed;
    [SerializeField] public float moveSpeed;
    [SerializeField] public float moveDistance;

    private Vector3 startPos;

    void Start()
    {
        startPos = transform.position;
    }

    // Update is called once per frame
    void Update()
    {
        float movement = Mathf.Sin(Time.time * moveSpeed) * moveDistance;
        transform.position = new Vector3(startPos.x + movement, startPos.y, startPos.z);
        transform.Rotate(0, 0, rotationSpeed * Time.deltaTime);
    }
}
